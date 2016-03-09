package at.softwarecraftsmen.test.benchmark;

import at.softwarecraftsmen.PersonNameMapper;
import at.softwarecraftsmen.model.PersonName;
import at.softwarecraftsmen.resource.PersonNameResource;
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

public class PersonNameMappingBenchmark {

    private static final PersonName name = new PersonNameFactory().newEntity();

    private static final PersonNameMapper mapstructMapper = PersonNameMapper.INSTANCE;

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void mapstruct() throws InterruptedException {
        mapstructMapper.map(name);
    }

    private static ModelMapper modelMapper = new ModelMapper();

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void modelmapper() throws InterruptedException {
        modelMapper.map(name, PersonNameResource.class);
    }

    private static Mapper dozerMapper = new DozerBeanMapper();

    @Benchmark
    @BenchmarkMode(Mode.SampleTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void dozer() throws InterruptedException {
        dozerMapper.map(name, PersonNameResource.class);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PersonNameMappingBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
