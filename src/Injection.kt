import domain.base.UseCaseHandler
import domain.usecases.*
import view.contactslist.ContactListUseCases
import view.contactslist.ContactListContract
import view.contactslist.ContactListPresenter

object Injection {
    fun provideContactPresenter() = ContactListPresenter(UseCaseHandler, ContactListUseCases()) as ContactListContract.Presenter

    fun provideGetContactDetail() = GetContactDetail()
    fun provideAddContact() = AddContact()
    fun provideDeleteContact() = DeleteContact()
    fun provideEditContact() = EditContact()
    fun provideFavouriteContact() = FavouriteContact()
    fun provideGetAllContacts()=GetAllContacts()
    fun provideGetFavouriteContacts()=GetFavouriteContacts()
}