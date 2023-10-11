package com.example.pr21_pr_33_gagarinovlev

import java.util.Date
import java.util.UUID

class Crime (var id:UUID = UUID.randomUUID()){
    var title=""
    var date:Date=Date()
    var isSolved=false

    constructor(id:UUID, title:String, date:Int,isSolved:Boolean):this(id){
        this.title=title
        this.date=Date()
        this.id=id
        this.isSolved=isSolved
    }
}