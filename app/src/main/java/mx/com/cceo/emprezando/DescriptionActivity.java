package mx.com.cceo.emprezando;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Fragment.DescriptionFragment;
import mx.com.cceo.emprezando.Fragment.InformationFragment;
import mx.com.cceo.emprezando.Fragment.MemoriesFragment;
import mx.com.cceo.emprezando.Fragment.ProgramFragment;
import mx.com.cceo.emprezando.Fragment.RegisterFragment;
import mx.com.cceo.emprezando.Fragment.VenueFragment;
import mx.com.cceo.emprezando.Model.DescriptionItem;

public class DescriptionActivity extends AppCompatActivity {

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private int selectedPosition;
    private int NUM_PAGES = 5;

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        FragmentManager fragmentManager = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.arrow_left_white_small);

        getSupportActionBar().setTitle("Conferencistas");

      //  drawerLayout = (DrawerLayout) findViewById(R.id.description_drawer);

        //binds drawer items to pager's pages
      //  initDrawer();

        //retrieves the position of the card the user selected to also set the adapter initial position
        Intent mIntent = getIntent();
        selectedPosition = mIntent.getIntExtra("position", 0);

        DescriptionItem saul = new DescriptionItem("Saúl Haro Vazquez","Macrolynk", "Ganador del emprendedor de año por la revista CNN Expansión 2015, y consultor de empresas como LG, GE, PLEXUS, MAHLE entre otras. \n\nSaúl Haro tiene más de 20 años de experiencia en Global Supply Chain Management, empezó su carrera en la industria automotriz en empresas como Valeo y Mabe. \n\nCatedrático en distintas universidades como son el Tecnológico Estudios Superiores de Monterrey (ITESM) y la Universidad Autónoma de San Luís Potosí (UASLP) entre otras, conferencista nacional e internacional, con ponencias sobre uso de tecnologías para Supply Chain y Negocios Internacionales.", R.drawable.saul_good);
        DescriptionItem jorge = new DescriptionItem("Jorge García","Outcom", "Director de empresa con representación en México, Co-fundador de la Alianza internacional de Empresarios Jóvenes del G20.\n\nEgresado en mayo de 2007 como Licenciado en ciencias de la comunicación por el Técnologico de Monterrey, Jorge García cuenta tambien con estudios sobre la creatividad para la generación de empresas por la Universidad Sunshine Coasten Queensland Australia.\n\n" +
                "Como empresario, se desempeña como Presidente del Grupo Innovación y Desarrollo Empresarial del Bajío S.C., Grupo al que pertenecen las empresas: Outcom Comunicación que Transforma, Outcom Worldwide y SCANmedia, marcas a través de las cuales se atiende a clientes corporativos nacionales y transnacionales desde sus sedes en las ciudades de Queretaro y Aguascalientes en México y su representación en Ottawa Canadá.", R.drawable.jorge_good);
        DescriptionItem juan = new DescriptionItem("Juan José Díaz","Eudoxa", "Empresario filósofo que diseñó el plan de RSE de la empresa de transporte ADO y participó en la elaboración del plan estratégico de Coparmex Nacional.\n\nJuan José Díaz nació en la Ciudad de México, es licenciado en Filosofía por la Universidad Panamericana. \n\nDe 2005 a 2009 trabajó en Coparmex Nacional, donde participó entre otros proyectos en la elaboración del Plan Estratégico 2008-2013.\n\n De 2011 a 2013 fue Asesor Corporativo de Responsabilidad Social Empresarial de Grupo ADO, donde coordinó la elaboración de la Estrategia Corporativa de Responsabilidad Social.", R.drawable.juan_good);
        DescriptionItem francisco = new DescriptionItem("Francisco García","Pacomer y Coachildren", "Empresario de 12 años con dos empresas. Una especializada en asesorar niños en la creación de empresas y la segunda de servicios de catering.\n\nPrimaria: de 1º. 3º Colegio Ciudad de México. D.F. ( 2009 a 2012 ).\n" +
                "De 4º. Aa 6º. Centro Educativo Vallarta, Estado de México ( 2012 a 2015 ).\n\n" +
                "Secundaria: 1º. Grado, Grupo Escolar Simón Bolivar 2015- Actualmente.\n\nDueño de la empresa Pacomer dedicada a la elaboración de galletas y comida para eventos sociales y empresariales.\n\n" +
                "Fundador de COACHILDREN. Consultoría enfocada a la asesoría en emprendimiento para niños.", R.drawable.big_francisco);
        DescriptionItem sergio = new DescriptionItem("Sergio Ramírez Zúñiga","Academia de Baloncesto Indígena", "Entrenador del equipo de niños triqui, ganador de la copa mundial de mini baloncesto en Argentina.\n\nFORMACION:\n" +
                "\n" +
                "PRIMARIA\n" +
                "SECUNDARIA\n" +
                "PREPARATORIA\n" +
                "COLEGIO MILITAR\n" +
                "PSICOLOGIA DEPORTIVA\n" +
                "10 NIVELES DEL CICEN\n" +
                "ADINISTRACION DE EMPRESAS\n" +
                "ENTRENADOR FISICO ESPECIALIZADO\n" +
                "NUTRICION PARA DEPORTISTAS DE ALTO RENDIMIENT", R.drawable.sergio_good);
        DescriptionItem guadalupe = new DescriptionItem("Guadalupe Gómez","Remedios Mágicos","Alquimista en jefe de la botica de dulces más importante de todo México. Y ganadora de “El Monstruo de la mercadotecnia” por CNN Expansión.\n\n2010– Ganadora de Galardón PYME como mejor nueva empresa incubada\n" +
                "\n" +
                "2011– Participación en Feria los Ángeles\n" +
                "México Emprende\n" +
                "\n" +
                "2011- a la Fecha. Integrante del GRECU. Grupo de Reflexión sobre Economía y Cultura.\n" +
                "UAM-Xochimilco.\n" +
                "\n" +
                "– Ponente en Congreso internacional de liderazgo", R.drawable.guadalupe_good);
        DescriptionItem arturo = new DescriptionItem("Arturo Gilio Hamdan","Palacio de Centenario", "Matador de toros y empresario proveedor de la empresa Nestle y socio mayoritario del centro de espectáculos coliseo.\n\nPresentación como novillero: 7 de septiembre de 1986, en Camargo\n" +
                "\n" +
                "Debut en la Plaza México: 2 de septiembre de 1990, alternando con Ángel García “El Chaval” y Mauricio Flores. Novillos de Curro Rivera.\n\nEsa temporada corto en total 5 orejas convirtiéndose en el triunfador de la plaza México al obtener los trofeos como mejor faena, mejor par de banderrillas, y triunfador de la temporada 1990", R.drawable.arturo_good);
        DescriptionItem vidal = new DescriptionItem("Vidal Cantú","Kenio Films y Veramiko", "Productor de la película Cantinflas y Co-productor de la película “The Perfect Game. Ganador del emprendedor de año CNN Expansión en el 2013 con la empresa Veramiko.\n\nVidal Cantú es un emprendedor en serie con experiencia en los sectores de tecnología, entretenimiento y cine. \n\nEn 1990 fundó Diel de México que fue adquirida en el 2000 por Grupo Telefónica e Infosel dentro del lanzamiento del portal terra.com. \n\nEn 2002 fue socio fundador y CTO de Naranya, empresa que producía contenido de entretenimiento para múltiples plataformas, tanto interactivas como tradicionales, Vidal conceptualizó, diseñó y dirigió el negocio móvil de esta empresa.", R.drawable.vidal_good);
        DescriptionItem norma = new DescriptionItem("Norma Romero", "Las Patronas", "La Mujer poderosa de Forbes que ayuda a los migrantes en su paso por México. \n\n2015: Reconocimiento de La Casa Anunciación del paso Texas, como Maestras de " +
                "Justicia. Texas, EUA.\n" +
                "\n" +
                "2015: Nombrada una de ‘Las 50 mujeres + poderosas de México’ por la Revista Forbes\n" +
                "México.\n" +
                "\n" +
                "2015: Candidatas como Las Patronas al premio Princesa de Asturias de la Concordia.\n" +
                "España.\n" +
                "\n" +
                "2014: Reconocimiento por su Loable Labor por parte del Gobierno del Estado de\n" +
                "Veracruz. México.", R.drawable.norma_good);
        DescriptionItem jose = new DescriptionItem("José Luis Garza", "Interjet","El líder que transformo la industria de la aviación en México.\n\nCiudadano Mexicano. Maestría en Management Science (Msc), The London School of Economics 1975-1976. Licenciatura en Ciencias Políticas, Universidad Iberoamericana México 1966-1971. Recibió importantes distinciones académicas y ha cursado una amplia variedad de cursos, seminarios sobre temas relacionados con Alta Dirección.\n\n" +
                "El Sr. Garza ha ocupado puestos de alta dirección en instituciones financieras mexicanas, empresas nacionales y extranjeras y en instituciones del Gobierno Federal: Banamex, Multivalores, Teleinformática de México, Caterpillar-Turbinas Solar, Grupo Gutsa, Infonavit y Secretaría de la Presidencia. Con más de 35 años de experiencia profesional.\n\n" +
                "El Sr. Garza ha sido el responsable directo de Interjet, aerolínea comercial mexicana que inauguró el nuevo concepto de Aerolíneas Eficientes en México.", R.drawable.jose_good);
        DescriptionItem armando = new DescriptionItem("Armando Guadiana", "Mineria Coapas","El minero que revolucionó la industria metalúrgica generando mas de 2000 empleos.\n\nExperiencia profesional\n\n" +
                "Diseño y Cálculo Estructural.\n" +
                "Evaluación de Proyectos de Inversión.\n" +
                "Contratista de obras minero-metalúrgicas durante más de 25 años y Promotor de exploraciones en reservas mineras para el establecimiento de medianas y pequeñas Empresas mineras.\n" +
                "Promotor y Accionista mayoritario de diversas Empresas Mineras, que han generado más de\n" +
                "2,000 empleos directos\n\nEmpresas:\n" +
                "\n" +
                "Compañía Minera Caopas, S.A. de C.V.\n" +
                "Materiales Industrializados, S.A. de C.V.\n" +
                "Materiales y Triturados El Pilar, S.A. de C.V.\n" +
                "Compañía Minera Ameca, S.A. de C.V.\n" +
                "Compañía Minera Huajicari, S.A. de C.V.", R.drawable.armando);
        DescriptionItem angfel = new DescriptionItem("José Ángel Gonzáles","Textiles Universales","El líder empresarial que ha dejado huella en la historia de Coparmex Aguascalientes.\n\n" +
                "Egresado de la UAA de la carrera de MVZ, con estudios de Postgrado en Administración de Empresas Agropecuarias.\n" +
                "\n" +
                "Posteriormente se desempeñó como Gerente de Servicio a Socios en GILSA, Pasteurizadora Sn Marcos.\n" +
                "\n" +
                "A partir de 1986 se convierte en Empresario, Como emprendedor y creador de diferente empresa del ramo inmobiliario y textil, así como inversionista en el sector financiero, en estas ramas económicas continua activo hasta hoy en día.\n" +
                "\n" +
                "Como integrante de diferentes cámaras empresariales, fue Vicepresidente de la Coparmex así como Presidente de la Comisión de Seguridad Pública de la misma en los años más difíciles 2007 2008 y 2009, además de Presidente de la Comisión de Desarrollo Económico, en estos años también fue integrante del Consejo Ciudadano de Seguridad Pública como Secretario.\n\nEn el 2010 se convirtió en Diputado Local, posteriormente diputado federal por el Edo de Aguascalientes, su trabajo lo desarrollo desde las Comisiones de Competitividad, Economía y Relaciones Exteriores.",R.drawable.angel);

        final ArrayList<DescriptionItem> list = new ArrayList<>();
        list.add(saul);
        list.add(jorge);
        list.add(juan);
        list.add(francisco);
        list.add(guadalupe);
        list.add(arturo);
        list.add(vidal);
        list.add(norma);
        list.add(jose);
        list.add(armando);
        list.add(angfel);

        //looks up ViewPager and sets its adapter
        mPager = (ViewPager) findViewById(R.id.main_pager);
        mPagerAdapter = new DescriptionPagerAdapter(getSupportFragmentManager(),list);
        mPager.setAdapter(mPagerAdapter);

        mPager.setCurrentItem(selectedPosition);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);

        FloatingActionButton fabRegister = (FloatingActionButton) findViewById(R.id.fab);
        fabRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"contacto@emprezado.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Duda de conferencia " + list.get(mPager.getCurrentItem()).getTitle());
                i.putExtra(Intent.EXTRA_TEXT, "");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                    //  Toast.makeText(RegisterFragment.this.getActivity(), "OK!", Toast.LENGTH_SHORT).show();
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(DescriptionActivity.this, "No hay clientes de correo instalados", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_description, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        this.finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }


    private class DescriptionPagerAdapter extends FragmentStatePagerAdapter {

        public ArrayList<DescriptionItem> dataSet;

        public DescriptionPagerAdapter(FragmentManager fm, ArrayList<DescriptionItem> dataSet) {
            super(fm);
            this.dataSet = dataSet;
        }

        @Override
        public Fragment getItem(int position) {

            DescriptionFragment descriptionFragment = new DescriptionFragment();
            descriptionFragment.setDescriptionItem(dataSet.get(position));
            return descriptionFragment;

        }

        @Override
        public int getCount() {
            return dataSet.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return dataSet.get(position).getTitle();
        }
    }
}
