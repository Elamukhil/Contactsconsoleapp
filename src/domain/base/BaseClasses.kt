package domain.base

sealed class Result<out L, out R> {

    data class Success<out L>(val data: L) : Result<L, Nothing>()
    data class Failure<out R>(val error: R) : Result<Nothing, R>()

    val isSuccess get() = this is Success<L>

    val isFailure get() = this is Failure<R>

    inline fun run(success: (L) -> Unit, failure: (R) -> Unit) {
        when (this) {
            is Success -> success(data)
            is Failure -> failure(error)
        }
    }
}

open class ErrorValue(val type: ErrorType, val message: String? = null)

enum class ErrorType {
    NO_DB_DATA,
    NO_NETWORK_DATA,
    NO_NETWORK,
    TIMEOUT,
    PARSING_FAILED,
    DOMAIN_ERROR,
    OTHER
}

enum class From {
    DB, NETWORK
}

enum class GetRequestType {
    DB_ONLY,
    NETWORK_ONLY,
    NETWORK_IF_NO_DB
}