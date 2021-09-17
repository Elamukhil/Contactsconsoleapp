package domain.usecases

import data.ContactsDataContract
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result
import domain.model.Contact

class EditContact (private val contactsDataContract: ContactsDataContract):  UseCase<EditContact.RequestValue, EditContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val contact: Contact) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        contactsDataContract.editContact(requestValues.contact)
        return Result.Success(ResponseValue)
    }

}