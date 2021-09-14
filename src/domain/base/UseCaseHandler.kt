package domain.base

//$Id$
import kotlinx.coroutines.*

object UseCaseHandler {

    suspend fun <T : UseCase.RequestValue, R : UseCase.ResponseValue, E: ErrorValue> executeAsync(useCase: UseCase<T, R, E>, values: T, scope: CoroutineScope): Deferred<Result<R, E>> {
        useCase.requestValues = values

        return scope.async(Dispatchers.IO) {
            useCase.run()
        }
    }

    suspend fun <T : UseCase.RequestValue, R : UseCase.ResponseValue, E: ErrorValue> executeNow(useCase: UseCase<T, R, E>, values: T): Result<R, E> {
        useCase.requestValues = values

        return withContext(Dispatchers.IO) {
            useCase.run()
        }
    }
}
