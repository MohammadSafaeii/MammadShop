package saf.moham.mammadshop.detail

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import saf.moham.mammadshop.R
import saf.moham.mammadshop.detail.viewModel.GraphViewModel
import saf.moham.mammadshop.utilities.MyActivity

class GraphActivity : MyActivity() {
    val graphViewModel:GraphViewModel by  viewModel { parametersOf(intent.extras!!.getString("id")) }
    var dates:MutableList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        val lineChart = findViewById<LineChart>(R.id.line_chart)

        graphViewModel.graphLiveData.observe(this) {
            if (it.isNotEmpty()) {
                var values: MutableList<Entry> = ArrayList()
                for (i in it.indices) {
                    values.add(Entry(i.toFloat(), it[i].price.toFloat()))
                    dates.add(it[i].date)
                }

                class MyXAxisFormatter : ValueFormatter() {
                    override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                        return dates.getOrNull(value.toInt()) ?: value.toString()
                    }
                }

                val lineDataSet = LineDataSet(values, "نمودار قیمت محصول").apply {
                    color = ContextCompat.getColor(applicationContext, R.color.gray_500)
                    lineWidth = 3f
                    valueTextSize = 10f
                    valueTextColor = ContextCompat.getColor(applicationContext, R.color.black)
                    setCircleColor(ContextCompat.getColor(applicationContext, R.color.black))
                    setDrawFilled(true)
                    fillDrawable = ContextCompat.getDrawable(applicationContext,R.drawable.graph_backgorund)
                }
                val iLineDataSets: MutableList<ILineDataSet> = ArrayList()
                iLineDataSets.add(lineDataSet)

                val lineData = LineData(iLineDataSets)
                lineChart.data = lineData
                val xAxis = lineChart.xAxis

                if (it.size>4)
                    xAxis.labelCount = 4
                else
                    xAxis.labelCount = it.size

                xAxis.valueFormatter = MyXAxisFormatter()
                //lineChart.animateX(500)
                lineChart.invalidate()
            }
        }



        graphViewModel.showProgressBarLiveData.observe(this){
            showProgressBar(it)
        }

    }
}