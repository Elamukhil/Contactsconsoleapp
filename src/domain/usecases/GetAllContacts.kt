package domain.usecases
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result
import domain.model.Contacts

class GetAllContacts : UseCase<GetAllContacts.RequestValue, GetAllContacts.ResponseValue, ErrorValue>() {
    class RequestValue : UseCase.RequestValue
    data class ResponseValue(val result: List<Contacts>) : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        val result = data.Contactsdata.getAllContacts()
        return if (result is Result.Success) {
            Result.Success(ResponseValue(result.data))
        } else {
            result as Result.Failure
        }
    }

}
