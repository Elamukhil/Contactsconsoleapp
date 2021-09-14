package data

import domain.base.ErrorValue
import domain.model.Contacts
import domain.base.Result

object Contactsdata{
    private val contacts = mutableListOf<Contacts>()
    fun addNewContact(temp: Contacts) {
        contacts.add(temp)
    }
    fun deleteContact(temp: Int) {
        contacts.removeAt(temp)
    }

    fun getAllContacts(): Result<List<Contacts>, ErrorValue>{
        return Result.Success(contacts)
    }
    fun getFavouriteContacts(): Result<List<Contacts>, ErrorValue>{
        return Result.Success(contacts.filter { it.favourite })
    }

    fun getContacts(i : Int): Result<Contacts, ErrorValue>{
        return Result.Success(contacts[i])
    }
    fun editContact(i: Int,modified : String,editposition :Int)
    {
        when(editposition)
        {
            1-> contacts[i].name=modified
            2-> contacts[i].address=modified
            3-> contacts[i].emailid=modified
            4-> contacts[i].phone=modified
        }
    }

    fun favouriteContact(selection:Boolean,i: Int)
    {
        contacts[i].favourite = selection
    }


}