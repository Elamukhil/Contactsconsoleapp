package domain.usecases

import domain.base.ErrorValue
import domain.base.Result
import domain.base.UseCase
import domain.model.Contacts

class AddContact :  UseCase<AddContact.RequestValue, AddContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val contact: Contacts) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        data.Contactsdata.addNewContact(requestValues.contact)
        return Result.Success(ResponseValue)
    }

}