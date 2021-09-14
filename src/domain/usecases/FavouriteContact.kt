package domain.usecases

import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result

class FavouriteContact :  UseCase<FavouriteContact.RequestValue, FavouriteContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val selection : Boolean, val i:Int) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        data.Contactsdata.favouriteContact(requestValues.selection,requestValues.i)
        return Result.Success(ResponseValue)
    }

}