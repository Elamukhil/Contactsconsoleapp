package data

import domain.base.ErrorValue
import domain.base.Result
import domain.model.Contact

class ContactsDataManager (
    private val contactsDataContractLocal: ContactsLocalDataContract
    ) :ContactsDataContract {

        companion object {

            private var instance: ContactsDataManager? = null

            @JvmStatic
            fun getInstance(): ContactsDataContract {

                if (instance == null) {
                    instance = ContactsDataManager(ContactsLocalDataService)
                }

                return instance as ContactsDataContract
            }
        }

    override fun addNewContact(contact: Contact) {
        contactsDataContractLocal.addNewContact(contact)
    }

    override fun deleteContact(contactId: Int) {
        contactsDataContractLocal.deleteContact(contactId)
    }

    override fun getAllContacts(): Result<List<Contact>, ErrorValue> {
        return contactsDataContractLocal.getAllContacts()
    }

    override fun getFavouriteContacts(): Result<List<Contact>, ErrorValue> {
        return contactsDataContractLocal.getFavouriteContacts()
    }

    override fun getContact(contactId: Int): Result<Contact, ErrorValue> {
       return contactsDataContractLocal.getContact(contactId)
    }

    override fun editContact(contact: Contact) {
       contactsDataContractLocal.editContact(contact)
    }

    override fun favouriteContact(isFavourite: Boolean, contactId: Int) {
        contactsDataContractLocal.favouriteContact(isFavourite,contactId)
    }


}