package domain.usecases
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result
import domain.model.Contact

class GetAllContacts : UseCase<GetAllContacts.RequestValue, GetAllContacts.ResponseValue, ErrorValue>() {
    class RequestValue : UseCase.RequestValue
    data class ResponseValue(val result: List<Contact>) : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        val result = data.ContactsData.getAllContacts()
        return if (result is Result.Success) {
            Result.Success(ResponseValue(result.data))
        } else {
            result as Result.Failure
        }
    }

}
