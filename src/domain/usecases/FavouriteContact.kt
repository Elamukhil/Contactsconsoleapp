package domain.usecases

import data.ContactsDataContract
import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result

class FavouriteContact(private val contactsDataContract: ContactsDataContract) :  UseCase<FavouriteContact.RequestValue, FavouriteContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val isFavourite : Boolean, val contactId:Int) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        contactsDataContract.favouriteContact(requestValues.isFavourite,requestValues.contactId)
        return Result.Success(ResponseValue)
    }

}