package view.contactslist

import domain.base.UseCaseHandler
import domain.model.Contact
import domain.base.Result
import domain.usecases.*

class ContactListPresenter(val handler: UseCaseHandler, val useCases: ContactListUseCases) : ContactListContract.Presenter() {
    override fun attach(view: ContactListContract.View) {
    }


    override fun detach() {
    }

    override suspend fun getAllContacts(): List<Contact> {
        val result = handler.executeNow(useCases.getAllContacts, GetAllContacts.RequestValue())
        if (result is Result.Success) {
            return result.data.result
        } else if (result is Result.Failure) {
            println(result.error.type)

        }
        return emptyList()
    }
        override suspend fun getFavouriteContacts():List<Contact>{
            val result = handler.executeNow(useCases.getFavouriteContacts, GetFavouriteContacts.RequestValue())
            if (result is Result.Success) {
                return result.data.result
            } else if (result is Result.Failure) {
                println(result.error.type)

            }
            return emptyList()

        }

        override suspend fun getContactDetail(contactId: Int): Contact? {
            val result = handler.executeNow(useCases.getContactDetail, GetContactDetail.RequestValue(contactId))
            if (result is Result.Success) {
                return result.data.result
            }
            return null

        }

        override suspend fun addContact(contact: Contact) {
            handler.executeNow(useCases.addContact, AddContact.RequestValue(contact))
        }

        override suspend fun deleteContact(contactId: Int) {
            handler.executeNow(useCases.deleteContact, DeleteContact.RequestValue(contactId))
        }

        override suspend fun editContact(contact: Contact) {
            handler.executeNow(useCases.editContact, EditContact.RequestValue(contact))
        }

        override suspend fun favouriteContact(isFavourite: Boolean, contactId: Int) {
            handler.executeNow(useCases.favouriteContact, FavouriteContact.RequestValue(isFavourite,contactId))
        }
    }






