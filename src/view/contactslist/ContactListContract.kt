package view.contactslist

import domain.model.Contacts
import view.base.BaseView
import view.base.ScopedBasePresenter


interface ContactListContract {
    interface View : BaseView
    abstract class Presenter : ScopedBasePresenter<View>() {

        abstract suspend fun getAllContacts()

        abstract suspend fun getFavouriteContacts()

        abstract suspend fun getContactDetail(position : Int)

        abstract suspend fun addContact(contact : Contacts)

        abstract suspend fun deleteContact(position: Int)

        abstract suspend fun editContact(position: Int,modified : String,editposition :Int)

        abstract suspend fun favouriteContact(selection: Boolean,position: Int)
    }
}
