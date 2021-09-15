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

    fun getContacts(position : Int): Result<Contacts, ErrorValue>{
        return Result.Success(contacts[position])
    }
    fun editContact(position: Int,modified : String,editposition :Int)
    {
        when(editposition)
        {
            1-> contacts[position].name=modified
            2-> contacts[position].address=modified
            3-> contacts[position].emailid=modified
            4-> contacts[position].phone=modified
        }
    }

    fun favouriteContact(selection:Boolean,i: Int)
    {
        contacts[i].favourite = selection
    }


}