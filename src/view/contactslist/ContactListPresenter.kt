package view.contactslist

import domain.base.UseCaseHandler
import domain.model.Contacts
import domain.base.Result
import domain.usecases.*

class ContactListPresenter(val handler: UseCaseHandler, val useCases: ContactListUseCases) : ContactListContract.Presenter() {
    override fun attach(view: ContactListContract.View) {
    }


    override fun detach() {
    }
    override suspend fun getAllContacts() {
        val result = handler.executeNow(useCases.getAllContacts, GetAllContacts.RequestValue())
        if (result is Result.Success) {
            Printer.printAllContacts(result.data.result)
        }

    }
    override suspend fun getFavouriteContacts() {
        val result = handler.executeNow(useCases.getFavouriteContacts, GetFavouriteContacts.RequestValue())
        if (result is Result.Success) {
            Printer.printAllContacts(result.data.result)
        }

    }
    override suspend fun getContactDetail(position: Int) {
            val result = handler.executeNow(useCases.getContactDetail, GetContactDetail.RequestValue(position))
            if (result is Result.Success) {
                Printer.printContact(result.data.result)
            }

    }
    override suspend fun addContact(contact : Contacts) {
         handler.executeNow(useCases.addContact, AddContact.RequestValue(contact))
    }

    override suspend fun deleteContact(position: Int) {
        handler.executeNow(useCases.deleteContact, DeleteContact.RequestValue(position))
    }

    override suspend fun editContact(position: Int,modified : String,editposition :Int) {
        handler.executeNow(useCases.editContact, EditContact.RequestValue(position,modified,editposition))
    }

    override suspend fun favouriteContact(selection: Boolean, position: Int) {
        handler.executeNow(useCases.favouriteContact, FavouriteContact.RequestValue(selection,position))
    }
}





