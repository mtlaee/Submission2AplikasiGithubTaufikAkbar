package com.example.submission2aplikasigithubtaufikakbar.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submission2aplikasigithubtaufikakbar.Api.ApiConfig
import com.example.submission2aplikasigithubtaufikakbar.Response.DataUser
import com.example.submission2aplikasigithubtaufikakbar.Response.DetailUserResponse
import com.example.submission2aplikasigithubtaufikakbar.Response.ResponseUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel: ViewModel() {
    val getUser = MutableLiveData<DetailUserResponse>()
    val listFollower = MutableLiveData<ArrayList<DataUser>>()
    val listFollowing = MutableLiveData<ArrayList<DataUser>>()

    /*get detail user*/
    fun setDataUserDetail(username: String) {
        ApiConfig.apiInstance
            .detailuser(username)
            .enqueue(object : Callback<DetailUserResponse> {
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if (response.isSuccessful) {
                        getUser.postValue((response.body()))
                    }
                }
                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    Log.d("Data Failure", t.message.toString())
                }
            })
    }
    fun getDataUserDetail(): LiveData<DetailUserResponse> {
        return getUser
    }

    /*get data follower*/
    fun setDataListFollower(username:String) {
        ApiConfig.apiInstance
            .getfollowers(username)
            .enqueue(object : Callback<ArrayList<DataUser>>{
                override fun onResponse(
                    call: Call<ArrayList<DataUser>>,
                    response: Response<ArrayList<DataUser>>
                ) {
                    if(response.isSuccessful) {
                        listFollower.postValue((response.body()))
                    }
                }
                override fun onFailure(call: Call<ArrayList<DataUser>>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }

            })
    }
    fun getDataLisFollowers():LiveData<ArrayList<DataUser>> {
        return listFollower
    }

    /*get data following*/
    fun setDataListFollowing(username: String) {
        ApiConfig.apiInstance
            .getfollowing(username)
            .enqueue(object : Callback<ArrayList<DataUser>> {
                override fun onResponse(
                    call: Call<ArrayList<DataUser>>,
                    response: Response<ArrayList<DataUser>>
                ) {
                    if (response.isSuccessful) {
                        listFollowing.postValue((response.body()))
                    }
                }
                override fun onFailure(call: Call<ArrayList<DataUser>>, t: Throwable) {
                    Log.d("Failure", t.message.toString())
                }

            })
    }
    fun getDataListFollowing(): LiveData<ArrayList<DataUser>> {
        return listFollowing
    }
}