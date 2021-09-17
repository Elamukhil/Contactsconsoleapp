package domain.usecases

import domain.base.ErrorValue
import domain.base.Result
import domain.base.UseCase

class DeleteContact :  UseCase<DeleteContact.RequestValue, DeleteContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val contactId: Int) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        data.ContactsData.deleteContact(requestValues.contactId)
        return Result.Success(ResponseValue)
    }

}