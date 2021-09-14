package view.contactslist

import domain.model.Contacts
import view.base.BaseView
import view.base.ScopedBasePresenter


interface ContactListContract {
    interface View : BaseView
    abstract class Presenter : ScopedBasePresenter<View>() {

        abstract suspend fun getAllContacts()

        abstract suspend fun getFavouriteContacts()

        abstract suspend fun getContactDetail(i: Int)

        abstract suspend fun addContact(contact : Contacts)

        abstract suspend fun deleteContact(i: Int)

        abstract suspend fun editContact(i: Int,modified : String,editposition :Int)

        abstract suspend fun favouriteContact(selection: Boolean,i :Int)
    }
}
