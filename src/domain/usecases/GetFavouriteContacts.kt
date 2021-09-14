package domain.usecases
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result
import domain.model.Contacts

class GetFavouriteContacts : UseCase<GetFavouriteContacts.RequestValue, GetFavouriteContacts.ResponseValue, ErrorValue>() {
    class RequestValue : UseCase.RequestValue
    data class ResponseValue(val result: List<Contacts>) : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        val result = data.Contactsdata.getFavouriteContacts()
        return if (result is Result.Success) {
            Result.Success(ResponseValue(result.data))
        } else {
            result as Result.Failure
        }
    }

}
