package data

import domain.base.ErrorValue
import domain.base.Result
import domain.model.Contact

interface ContactsDataContract {

    fun addNewContact(contact: Contact)
    fun deleteContact(contactId: Int)
    fun getAllContacts(): Result<List<Contact>, ErrorValue>
    fun getFavouriteContacts(): Result<List<Contact>, ErrorValue>
    fun getContact(contactId : Int): Result<Contact, ErrorValue>
    fun editContact(contact : Contact)
    fun favouriteContact(isFavourite:Boolean,contactId: Int)

}