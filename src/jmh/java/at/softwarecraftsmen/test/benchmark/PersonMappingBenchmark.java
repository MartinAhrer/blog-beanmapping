package at.softwarecraftsmen.test.benchmark;

import at.softwarecraftsmen.PersonMapper;
import at.softwarecraftsmen.PersonNameMapper;
import at.softwarecraftsmen.model.Person;
import at.softwarecraftsmen.model.PersonName;
import at.softwarecraftsmen.resource.PersonNameResource;
import at.softwarecraftsmen.test.shared.PersonFactory;
import at.softwarecraftsmen.test.shared.PersonNameFactory;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.modelmapper.ModelMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class PersonMappingBenchmark {

    private static final Person person = new PersonFactory().newEntity();

    private static final PersonMapper mapstructMapper = PersonMapper.INSTANCE;

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void mapstruct() throws InterruptedException {
        mapstructMapper.map(person);
    }

    private static ModelMapper modelMapper = new ModelMapper();

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void modelmapper() throws InterruptedException {
        modelMapper.map(person, PersonNameResource.class);
    }

    private static Mapper dozerMapper = new DozerBeanMapper();

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void dozer() throws InterruptedException {
        dozerMapper.map(person, PersonNameResource.class);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PersonMappingBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
