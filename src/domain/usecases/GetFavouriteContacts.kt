package domain.usecases
import data.ContactsDataContract
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result
import domain.model.Contact

class GetFavouriteContacts(private val contactsDataContract: ContactsDataContract) : UseCase<GetFavouriteContacts.RequestValue, GetFavouriteContacts.ResponseValue, ErrorValue>() {
    class RequestValue : UseCase.RequestValue
    data class ResponseValue(val result: List<Contact>) : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        val result = contactsDataContract.getFavouriteContacts()
        return if (result is Result.Success) {
            Result.Success(ResponseValue(result.data))
        } else {
            result as Result.Failure
        }
    }

}
