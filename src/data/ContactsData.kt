package data

import domain.base.ErrorType
import domain.base.ErrorValue
import domain.model.Contact
import domain.base.Result


object ContactsData{
    private val contacts = mutableListOf<Contact>()
    fun addNewContact(temp: Contact) {
        contacts.add(temp)
    }
    fun deleteContact(contactId: Int) {
        val temp= contacts.filter { it.contactId==contactId }
        contacts.removeAt(contacts.indexOf(temp[0]))
    }

    fun getAllContacts(): Result<List<Contact>, ErrorValue>{
        return if(contacts.isNotEmpty())
            Result.Success(contacts)
        else
            Result.Failure(ErrorValue(ErrorType.NO_DB_DATA))
    }
    fun getFavouriteContacts(): Result<List<Contact>, ErrorValue>{
        val temp=contacts.filter { it.isFavourite }
        return if(temp.isNotEmpty())
            Result.Success(temp)
        else
            Result.Failure(ErrorValue(ErrorType.NO_DB_DATA))
    }

    fun getContact(contactId : Int): Result<Contact, ErrorValue>{
        val temp= contacts.filter { it.contactId==contactId }
        return if (temp.isNotEmpty())
            Result.Success(temp[0])
        else
            Result.Failure(ErrorValue(ErrorType.NO_DB_DATA))
    }
    fun editContact(contact : Contact)
    {
        val temp= contacts.filter { it.contactId==contact.contactId }
        val index= contacts.indexOf(temp[0])
        contacts[index]=contact
    }

    fun favouriteContact(isFavourite:Boolean,contactId: Int)
    {
        val temp= contacts.filter { it.contactId==contactId }
        contacts[contacts.indexOf(temp[0])].isFavourite=isFavourite
    }

}