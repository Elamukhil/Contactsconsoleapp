import data.ContactsDataManager
import domain.base.UseCaseHandler
import domain.usecases.*
import view.contactslist.ContactListUseCases
import view.contactslist.ContactListContract
import view.contactslist.ContactListPresenter

object Injection {
    fun provideContactPresenter() = ContactListPresenter(UseCaseHandler, ContactListUseCases()) as ContactListContract.Presenter

    fun provideGetContactDetail() = GetContactDetail(provideContactDataManager())
    fun provideAddContact() = AddContact(provideContactDataManager())
    fun provideDeleteContact() = DeleteContact(provideContactDataManager())
    fun provideEditContact() = EditContact(provideContactDataManager())
    fun provideFavouriteContact() = FavouriteContact(provideContactDataManager())
    fun provideGetAllContacts()=GetAllContacts(provideContactDataManager())
    fun provideGetFavouriteContacts()=GetFavouriteContacts(provideContactDataManager())

    private fun provideContactDataManager() = ContactsDataManager.getInstance()
}