package com.example.razli.pense


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.razli.pense.model.Article
import kotlinx.android.synthetic.main.fragment_articles.*
import kotlinx.android.synthetic.main.single_article_card.view.*

class ArticlesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onStart() {
        super.onStart()

        // todo move this later to presenter
        val article1 = Article(1, "A Title", getString(R.string.lorem_ipsum_text))
        val article2 = Article(1, "A Title", getString(R.string.lorem_ipsum_text))
        val article3 = Article(1, "A Title", getString(R.string.lorem_ipsum_text))
        val article4 = Article(1, "A Title", getString(R.string.lorem_ipsum_text))
        val article5 = Article(1, "A Title", getString(R.string.lorem_ipsum_text))
        val article6 = Article(1, "A Title", getString(R.string.lorem_ipsum_text))

        val articleList = ArrayList<Article>().also {
            it.add(article1)
            it.add(article2)
            it.add(article3)
            it.add(article4)
            it.add(article5)
            it.add(article6)
        }

        initRecyclerView(articleList)
    }

    private fun initRecyclerView(articleList: ArrayList<Article>) {
        val adapter = HorizontalAdapter(articleList)
        articles_recyclerview.adapter = adapter

        // todo consider changing the context below to use the parent context
        val layoutManager = GridLayoutManager(context, 1)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        articles_recyclerview.layoutManager = layoutManager
    }


}

class HorizontalAdapter(var articleList: ArrayList<Article>) : RecyclerView.Adapter<HorizontalAdapter.CustomViewHolder>() {

    // Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    // This new ViewHolder should be constructed with a new View that can represent the items of the given type.
    // The new ViewHolder will be used to display items of the adapter using onBindViewHolder
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.single_article_card, p0, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    // Called by RecyclerView to display the data at the specified position. This method should
    // update the contents of the itemView to reflect the item at the given position.
    override fun onBindViewHolder(p0: CustomViewHolder, p1: Int) {
        //p0.itemView.image_view
        p0.itemView.title_textview.text = articleList[p1].title
        p0.itemView.description_textview.text = articleList[p1].description
        p0.itemView.date_textview.text = articleList[p1].publishDate
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view)
}