package view.contactslist
class ContactListUseCases {
    val getContactDetail = Injection.provideGetContactDetail()
    val addContact = Injection.provideAddContact()
    val editContact= Injection.provideEditContact()
    val getAllContacts=Injection.provideGetAllContacts()
    val getFavouriteContacts=Injection.provideGetFavouriteContacts()
    val deleteContact= Injection.provideDeleteContact()
    val favouriteContact=Injection.provideFavouriteContact()
}