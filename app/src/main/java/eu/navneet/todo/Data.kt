package eu.navneet.todo

object Data {
    var listdata= mutableListOf<CardInfo>()
    fun setData(title: String,priority: String){
        listdata.add(CardInfo(title,priority))
    }

    fun getAllData():List<CardInfo> {

        return listdata
    }
    fun getData(pos:Int): CardInfo {
        return listdata[pos]
    }
    fun deleteData(pos: Int){
        listdata.removeAt(pos)
    }
    fun updateData(pos: Int,taskName: String,taskPriority: String){
        listdata[pos].title=taskName
        listdata[pos].priority=taskPriority
    }
}