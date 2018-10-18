package com.example.fgoncalves.calculadora_imc
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var atv: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        swSexo?.setOnClickListener {
            exibir()
        }


        /**
         * Captura os dados da seekbar idade e exibe no campo idade_txt
         */

        idade_sb.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        idade_txt.text = (progress.toString() + " anos")
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        idade_txt.text = (seekBar?.progress.toString() + " anos")
                    }

                }
        )

        /**
         * captura os dados da seekbar peso e exibe no campo peso_txt
         */
        peso_sb.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        peso_txt.text = (progress.toString() + " kg")
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        peso_txt.text = (seekBar?.progress.toString() + " kg")
                    }

                }
        )

        /**
         * captura os dados da seekbar altura e exibe no campo altura_txt
         */
        altura_sb.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        altura_txt.text = (progress.toString() + " cm")
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        altura_txt.text = (seekBar?.progress.toString() + " cm")
                    }

                }
        )


        /**
         * Botão calcular, captura os valores da seekbar e radiogroup, calcula o IMC, exibindo o resultado e classifica o IMC no RatingBar.
         */

        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            atv = ""

            when (checkedId) {
                R.id.rdbSedentario -> atv = "Você precisa se exercitar mais!"
                R.id.rdbModerado -> atv = "Você esta no camino certo!"
                R.id.rdbIntenso -> atv = "Parabéns, sua saúde agradece!"
            }


            calcular_btn.setOnClickListener {


                val altura_int = altura_sb.progress.toDouble()
                val peso_int = peso_sb.progress.toDouble()

                val imc = peso_int / ((altura_int * altura_int) / 10000)


                resultado2.text = atv


                if (imc < 16) {

                    resultado.text = "%.1f".format(imc) + " IMC muito abaixo do peso."
                    classifica.rating = 1.5.toFloat()

                } else if (imc > 16 && imc < 18) {
                    resultado.text = "%.1f".format(imc) + " IMC abaixo do peso."
                    classifica.rating = 3.toFloat()

                } else if (imc > 18 && imc < 24) {
                    resultado.text = "%.1f".format(imc) + " IMC normal."
                    classifica.rating = 5.toFloat()

                } else if (imc > 25 && imc < 29) {
                    resultado.text = "%.1f".format(imc) + " IMC acima do normal."
                    classifica.rating = 3.toFloat()

                } else if (imc > 30) {
                    resultado.text = "%.1f".format(imc) + " IMC muito acima do peso."
                    classifica.rating = 1.5.toFloat()

                }


            }


        }


    }

    /**
     * Função para exibir o status no Switch
     */
    private fun exibir() {
        if (swSexo.isChecked) {

            sexo_txt.text = " Mulher"

        } else {

            sexo_txt.text = "Homem"
        }
    }

}










