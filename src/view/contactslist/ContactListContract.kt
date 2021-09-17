package view.contactslist

import domain.model.Contact
import view.base.BaseView
import view.base.ScopedBasePresenter


interface ContactListContract {
    interface View : BaseView
    abstract class Presenter : ScopedBasePresenter<View>() {

        abstract suspend fun getAllContacts():List<Contact>

        abstract suspend fun getFavouriteContacts():List<Contact>

        abstract suspend fun getContactDetail(contactId : Int) : Contact?

        abstract suspend fun addContact(contact : Contact)

        abstract suspend fun deleteContact(contactId: Int)

        abstract suspend fun editContact(contact: Contact)

        abstract suspend fun favouriteContact(isFavourite: Boolean,contactId: Int)
    }
}
