package domain.usecases
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result
import domain.model.Contact

class GetContactDetail : UseCase<GetContactDetail.RequestValue, GetContactDetail.ResponseValue, ErrorValue>() {
    data class RequestValue(val contactId: Int) : UseCase.RequestValue
    data class ResponseValue(val result: Contact) : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        val result = data.ContactsData.getContact(requestValues.contactId)
        return if (result is Result.Success) {
            Result.Success(ResponseValue(result.data))
        } else {
            result as Result.Failure
        }
        }

}
