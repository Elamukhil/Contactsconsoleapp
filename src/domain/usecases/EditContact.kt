package domain.usecases

import domain.base.ErrorValue
import domain.base.UseCase
import domain.base.Result

class EditContact :  UseCase<EditContact.RequestValue, EditContact.ResponseValue, ErrorValue>() {
    data class RequestValue(val position: Int,val modified : String,val editposition :Int) : UseCase.RequestValue
    object ResponseValue : UseCase.ResponseValue

    override suspend fun executeUseCase(requestValues: RequestValue): Result<ResponseValue, ErrorValue> {
        data.Contactsdata.editContact(requestValues.position,requestValues.modified,requestValues.editposition)
        return Result.Success(ResponseValue)
    }

}