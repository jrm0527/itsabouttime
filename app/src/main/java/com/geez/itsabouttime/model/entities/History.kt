package com.geez.itsabouttime.model.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Parcelize
@Entity(tableName = "history")
data class History (

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var date: LocalDateTime,

    @ColumnInfo(name = "clock_in")
    var clockIn: String,

    @ColumnInfo(name = "lunch_out")
    var lunchOut: String,

    @ColumnInfo(name = "lunch_in")
    var lunchIn: String,

    @ColumnInfo(name = "clock_out")
    var clockOut: String,

    var hours: String,

): Parcelable {

    val createdDateFormatted : String
        get() =date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
}