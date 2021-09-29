package com.example.spzquiz

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class Game : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val ecvpic = findViewById<ImageView>(R.id.imageView)
        val citiesNames = listOf<String>(
            "BA,Bratislava",
            "BB,Banská Bystrica",
            "BJ,Bardejov",
            "BL,Bratislava",
            "BN,Bánovce nad Bebravou",
            "BR,Brezno",
            "BS,Banská Štiavnica",
            "BT,Bratislava",
            "BY,Bytča",
            "CA,Čadca",
            "DK,Dolný Kubín",
            "DS,Dunajská Streda",
            "DT,Detva",
            "GA,Galanta",
            "GL,Gelnica",
            "HC,Hlohovec",
            "HE,Humenne",
            "IL,Ilava",
            "KA,Krupina",
            "KE,Košice",
            "KK,Kežmarok",
            "KM,Kysucké Nové Mesto",
            "KN,Komárno",
            "KS,Košice okolie",
            "LC,Lučenec",
            "LE,Levoča",
            "LM,Liptovský Mikuláš",
            "LV,Levice",
            "MA,Malacky",
            "MI,Michalovce",
            "ML,Medzilaborce",
            "MT,Martin",
            "MY,Myjava",
            "NM,Nové Mesto nad Váhom",
            "NO,Námestovo",
            "NR,Nitra",
            "NZ,Nové Zámky",
            "PB,Povazská Bystrica",
            "PD,Prievidza",
            "PE,Partizánske",
            "PK,Pezinok",
            "PN,Pieštany",
            "PO,Prešov",
            "PP,Poprad",
            "PT,Poltár",
            "PU,Púchov",
            "RA,Revúca",
            "RK,Ružomberok",
            "RS,Rimavská Sobota",
            "RV,Rožňava",
            "SA,Šaľa",
            "SB,Sabinov",
            "SC,Senec",
            "SE,Senica",
            "SI,Skalica",
            "SK,Svidník",
            "SL,Stará Ľubovna",
            "SN,Spišská Nová Ves",
            "SO,Sobrance",
            "SP,Stropkov",
            "SV,Snina",
            "TN,Trenčín",
            "TO,Topoľčany",
            "TR,Turcianske teplice",
            "TS,Tvrdošín",
            "TT,Trnava",
            "TV,Trebišov",
            "VK,Veľký Krtíš",
            "VT,Vranov nad Topľou",
            "ZA,Žilina",
            "ZC,Žarnovica",
            "ZH,Žiar nad Hronom",
            "ZM,Zlaté Moravce",
            "ZV,Zvolen"
        )
        val citiesPics = listOf<String>(
            "ba_bratislava",
            "bb_banskabystrica",
            "bj_bardejov",
            "bl_bratislava",
            "bn_banovce_nad_bebravou",
            "br_brezno",
            "bs_banska_stiavnica",
            "bt_bratislava",
            "by_bytca",
            "ca_cadca",
            "dk_dolny_kubin",
            "ds_dunajska_streda",
            "dt_detva",
            "ga_galanta",
            "gl_gelnica",
            "hc_hlohovec",
            "he_humenne",
            "il_ilava",
            "ka_krupina",
            "ke_kosice",
            "kk_kezmarok",
            "km_kysucke_nove_mesto",
            "kn_komarno",
            "ks_kosice_okolie",
            "lc_lucenec",
            "le_levoca",
            "lm_liptovsky_mikulas",
            "lv_levice",
            "ma_malacky",
            "mi_michalovce",
            "ml_medzilaborce",
            "mt_martin",
            "my_myjava",
            "nm_nove_mesto_nad_vahom",
            "no_namestovo",
            "nr_nitra",
            "nz_nove_zamky",
            "pb_povazska_bystrica",
            "pd_prievidza",
            "pe_partizanske",
            "pk_pezinok",
            "pn_piestany",
            "po_presov",
            "pp_poprad",
            "pt_poltar",
            "pu_puchov",
            "ra_revuca",
            "rk_ruzomberok",
            "rs_rimavska_sobota",
            "rv_roznava",
            "sa_sala",
            "sb_sabinov",
            "sc_senec",
            "se_senica",
            "si_skalica",
            "sk_svidnik",
            "sl_stara_lubovna",
            "sn_spisska_nova_ves",
            "so_sobrance",
            "sp_stropkov",
            "sv_snina",
            "tn_trencin",
            "to_topolcany",
            "tr_turcianske_teplice",
            "ts_tvrdosin",
            "tt_trnava",
            "tv_trebisov",
            "vk_velky_krtis",
            "vt_vranov_nad_toplou",
            "za_zilina",
            "zc_zarnovica",
            "zh_ziar_nad_hronom",
            "zm_zlate_moravce",
            "zv_zvolen"

        )

        val btn1 = findViewById<Button>(R.id.button1)
        val btn2 = findViewById<Button>(R.id.button2)
        val btn3 = findViewById<Button>(R.id.button3)

        var usedup = mutableListOf<Int>()

        fun newPic(used: MutableList<Int>): MutableList<Int>
        {

            val pictureShown = Random.nextInt(74)
            while (pictureShown in used)
            {
                val pictureShown = Random.nextInt(74)
            }
            val drawableId = getResources().getIdentifier(citiesPics[pictureShown], "drawable", getPackageName())
            var incorrect1 = pictureShown-1
            var incorrect2 = pictureShown+1
            if(incorrect1==-1)
            {
                incorrect1 = incorrect2+1

            }

            if(incorrect2==74)
            {
                incorrect2 = incorrect1-1
            }

            val correctCity = citiesNames[pictureShown].slice(3..citiesNames[pictureShown].length-1)
            val incorrectCity1 = citiesNames[incorrect1].slice(3..citiesNames[incorrect1].length-1)
            val incorrectCity2 = citiesNames[incorrect2].slice(3..citiesNames[incorrect2].length-1)

            val correctBtn = Random.nextInt(1,4)

            when(correctBtn){
                1 -> {btn1.setText(correctCity)
                    btn2.setText(incorrectCity1)
                    btn3.setText(incorrectCity2)}

                2 -> {btn1.setText(incorrectCity1)
                    btn2.setText(correctCity)
                    btn3.setText(incorrectCity2)
                }
                3 -> {btn1.setText(incorrectCity1)
                    btn2.setText(incorrectCity2)
                    btn3.setText(correctCity)
                }
            }

            used.add(pictureShown)

            ecvpic.setBackgroundResource(drawableId)
            return used
        }

        usedup = newPic(usedup)


    }
}