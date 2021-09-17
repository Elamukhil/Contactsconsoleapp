package domain.model

data class Contact(
    val contactId : Int,
    var name : String,
    var address : Address,
    var emailId : String,
    var phone : MutableList<String>,
    var isFavourite : Boolean
)
