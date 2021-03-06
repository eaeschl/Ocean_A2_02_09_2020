package io.github.paulosalvatore.ocean_a2_02_09_2020

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_perfil.*

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val nome = intent.getStringExtra("NOME")
        val idade = intent.getStringExtra("IDADE")

        textView.text = String.format(
            getString(R.string.resultado_nome_idade),
            nome,
            idade
        )

        // Toast
//        Toast.makeText(this, "Tela de perfil aberta com sucesso.", Toast.LENGTH_LONG).show()

        // Snackbar
        Snackbar.make(textView, "Tela de perfil aberta com sucesso.", Snackbar.LENGTH_INDEFINITE)
            .setAction("Reconectar") {
                // Toast
                Toast.makeText(this, "Reconectar foi clicado.", Toast.LENGTH_LONG).show()
            }.show()

        // AlertDialog
        val builder = AlertDialog.Builder(this)

        builder.apply {
            setPositiveButton("Sim") { _, _ ->
                Toast.makeText(this@PerfilActivity, "'Sim' foi clicado", Toast.LENGTH_LONG).show()
            }

            setNegativeButton("Não") { _, _ ->
                Toast.makeText(this@PerfilActivity, "'Não' foi clicado", Toast.LENGTH_LONG).show()
            }
        }

        builder.setMessage("Mensagem").setTitle("Titulo")
        val dialog = builder.create()
        dialog.show()

        // Testando importação de uma biblioteca de gráficos
        val graph = findViewById<View>(R.id.graph) as GraphView
        val series: LineGraphSeries<DataPoint> = LineGraphSeries(
            arrayOf(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        graph.addSeries(series)
    }
}
