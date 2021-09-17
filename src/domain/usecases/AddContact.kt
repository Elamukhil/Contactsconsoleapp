package domain.usecases

import data.ContactsDataContract
import domain.base.ErrorValue
import domain.base.Result
import domain.base.UseCase
import domain.model.Contact

class AddContact (private val contactsDataContract: ContactsDataContract):  UseCase<AddContact.RequestValue, AddContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val contact: Contact) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        contactsDataContract.addNewContact(requestValues.contact)
        return Result.Success(ResponseValue)
    }

}