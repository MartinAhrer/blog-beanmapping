package at.softwarecraftsmen.test.shared

/**
 * Support the construction of entities for testing. Generally a factory should try to only initialize mandatory properties se we don't impose too many dependencies and keep
 * tests simple. A complex test case can always pass in all optional properties as extra factory method parameters.
 * @param < T >
 */
abstract class AbstractEntityFactory<T> implements EntityFactory<T> {
    /**
     * This allows the factory to be called like a closure:
     * <pre>
     *     def factory = new CustomerEntityFactory()
     *     def entity = factory()
     * </pre>
     * @param args the arguments for the factory.
     * @return
     */
    T call(Map args = [:]) {
        return newEntity(args)
    }
}