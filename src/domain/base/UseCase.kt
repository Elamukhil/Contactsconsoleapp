package domain.base


abstract class UseCase<Q : UseCase.RequestValue, P : UseCase.ResponseValue, E : ErrorValue> {

    lateinit var requestValues: Q

    suspend fun run(): Result<P, E> {
        return executeUseCase(requestValues)
    }

    protected abstract suspend fun executeUseCase(requestValues: Q): Result<P, E>

    interface RequestValue
    interface ResponseValue
}
