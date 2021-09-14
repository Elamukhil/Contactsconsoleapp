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
    override suspend fun getContactDetail(i: Int) {
            val result = handler.executeNow(useCases.getContactDetail, GetContactDetail.RequestValue(i))
            if (result is Result.Success) {
                Printer.printContact(result.data.result)
            }

    }
    override suspend fun addContact(contact : Contacts) {
         handler.executeNow(useCases.addContact, AddContact.RequestValue(contact))
    }

    override suspend fun deleteContact(i : Int) {
        handler.executeNow(useCases.deleteContact, DeleteContact.RequestValue(i))
    }

    override suspend fun editContact(i: Int,modified : String,editposition :Int) {
        handler.executeNow(useCases.editContact, EditContact.RequestValue(i,modified,editposition))
    }

    override suspend fun favouriteContact(selection: Boolean, i: Int) {
        handler.executeNow(useCases.favouriteContact, FavouriteContact.RequestValue(selection,i))
    }
}





