package mx.com.cceo.emprezando;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import mx.com.cceo.emprezando.Fragment.DescriptionFragment;
import mx.com.cceo.emprezando.Fragment.InformationFragment;
import mx.com.cceo.emprezando.Fragment.MemoriesFragment;
import mx.com.cceo.emprezando.Fragment.ProgramFragment;
import mx.com.cceo.emprezando.Fragment.RegisterFragment;
import mx.com.cceo.emprezando.Fragment.VenueFragment;
import mx.com.cceo.emprezando.Model.DescriptionItem;

public class DescriptionActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private int selectedPosition;
    private int NUM_PAGES = 5;
    private  DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        setTitle("Expositores");

        drawerLayout = (DrawerLayout) findViewById(R.id.description_drawer);

        //binds drawer items to pager's pages
        initDrawer();

        //retrieves the position of the card the user selected to also set the adapter initial position
        Intent mIntent = getIntent();
        selectedPosition = mIntent.getIntExtra("position", 0);

        DescriptionItem saul = new DescriptionItem("Saúl Haro Vazquez","Macrolynk", "Ganador del emprendedor de año por la revista CNN Expansión 2015, y consultor de empresas como LG, GE, PLEXUS, MAHLE entre otras. \n\nSaúl Haro tiene más de 20 años de experiencia en Global Supply Chain Management, empezó su carrera en la industria automotriz en empresas como Valeo y Mabe. Catedrático en distintas universidades como son el Tecnológico Estudios Superiores de Monterrey (ITESM) y la Universidad Autónoma de San Luís Potosí (UASLP) entre otras, conferencista nacional e internacional, con ponencias sobre uso de tecnologías para Supply Chain y Negocios Internacionales.", R.drawable.saulh);
        DescriptionItem jorge = new DescriptionItem("Jorge García","Outcom", "Director de empresa con representación en México, Co-fundador de la Alianza internacional de Empresarios Jóvenes del G20.\n\nEgresado en mayo de 2007 como Licenciado en ciencias de la comunicación por el Técnologico de Monterrey, Jorge García cuenta tambien con estudios sobre la creatividad para la generación de empresas por la Universidad Sunshine Coasten Queensland Australia." +
                "Como empresario, se desempeña como Presidente del Grupo Innovación y Desarrollo Empresarial del Bajío S.C., Grupo al que pertenecen las empresas: Outcom Comunicación que Transforma, Outcom Worldwide y SCANmedia, marcas a través de las cuales se atiende a clientes corporativos nacionales y transnacionales desde sus sedes en las ciudades de Queretaro y Aguascalientes en México y su representación en Ottawa Canadá.", R.drawable.jorge);
        DescriptionItem juan = new DescriptionItem("Juan José Díaz","Eudoxa", "Empresario filósofo que diseñó el plan de RSE de la empresa de transporte ADO y participó en la elaboración del plan estratégico de Coparmex Nacional.\n\nJuan José Díaz nació en la Ciudad de México, es licenciado en Filosofía por la Universidad Panamericana. De 2005 a 2009 trabajó en Coparmex Nacional, donde participó entre otros proyectos en la elaboración del Plan Estratégico 2008-2013. De 2011 a 2013 fue Asesor Corporativo de Responsabilidad Social Empresarial de Grupo ADO, donde coordinó la elaboración de la Estrategia Corporativa de Responsabilidad Social.", R.drawable.juan);
        DescriptionItem francisco = new DescriptionItem("Francisco García","Pacomer y Coachildren", "Empresario de 12 años con dos empresas. Una especializada en asesorar niños en la creación de empresas y la segunda de servicios de catering.\n\nPrimaria: de 1º. 3º Colegio Ciudad de México. D.F. ( 2009 a 2012 ).\n" +
                "De 4º. Aa 6º. Centro Educativo Vallarta, Estado de México ( 2012 a 2015 ).\n" +
                "Secundaria: 1º. Grado, Grupo Escolar Simón Bolivar 2015- Actualmente.", R.drawable.francisco);
        DescriptionItem sergio = new DescriptionItem("Sergio Ramírez Zúñiga","Academia de Baloncesto Indígena", "Entrenador del equipo de niños triqui, ganador de la copa mundial de mini baloncesto en Argentina.\nFORMACION:\n" +
                "\n" +
                "PRIMARIA\n" +
                "SECUNDARIA\n" +
                "PREPARATORIA\n" +
                "COLEGIO MILITAR\n" +
                "PSICOLOGIA DEPORTIVA\n" +
                "10 NIVELES DEL CICEN\n" +
                "ADINISTRACION DE EMPRESAS\n" +
                "ENTRENADOR FISICO ESPECIALIZADO\n" +
                "NUTRICION PARA DEPORTISTAS DE ALTO RENDIMIENT", R.drawable.sergio);
        DescriptionItem guadalupe = new DescriptionItem("Guadalupe Gómez","Remedios Mágicos","Alquimista en jefe de la botica de dulces más importante de todo México. Y ganadora de “El Monstruo de la mercadotecnia” por CNN Expansión.\n2010– Ganadora de Galardón PYME como mejor nueva empresa incubada\n" +
                "\n" +
                "2011– Participación en Feria los Ángeles\n" +
                "México Emprende\n" +
                "\n" +
                "2011- a la Fecha. Integrante del GRECU. Grupo de Reflexión sobre Economía y Cultura.\n" +
                "UAM-Xochimilco.\n" +
                "\n" +
                "– Ponente en Congreso internacional de liderazgo", R.drawable.guadalupe);
        DescriptionItem arturo = new DescriptionItem("Arturo Gilio Hamdan","Palacio de Centenario", "Matador de toros y empresario proveedor de la empresa Nestle y socio mayoritario del centro de espectáculos coliseo.\nPresentación como novillero: 7 de septiembre de 1986, en Camargo\n" +
                "\n" +
                "Debut en la Plaza México: 2 de septiembre de 1990, alternando con Ángel García “El Chaval” y Mauricio Flores. Novillos de Curro Rivera. Esa temporada corto en total 5 orejas convirtiéndose en el triunfador de la plaza México al obtener los trofeos como mejor faena, mejor par de banderrillas, y triunfador de la temporada 1990", R.drawable.arturo);
        DescriptionItem vidal = new DescriptionItem("Vidal Cantú","Kenio Films y Veramiko", "Productor de la película Cantinflas y Co-productor de la película “The Perfect Game. Ganador del emprendedor de año CNN Expansión en el 2013 con la empresa Veramiko.\n\nVidal Cantú es un emprendedor en serie con experiencia en los sectores de tecnología, entretenimiento y cine. En 1990 fundó Diel de México que fue adquirida en el 2000 por Grupo Telefónica e Infosel dentro del lanzamiento del portal Terra.com En 2002 fue socio fundador y CTO de Naranya, empresa que producía contenido de entretenimiento para múltiples plataformas, tanto interactivas como tradicionales, Vidal conceptualizó, diseñó y dirigió el negocio móvil de esta empresa.", R.drawable.vidal);
        DescriptionItem norma = new DescriptionItem("Norma Romero", "Las Patronas", "La Mujer poderosa de Forbes que ayuda a los migrantes en su paso por México. \n2015: Reconocimiento de La Casa Anunciación del paso Texas, como Maestras de\n" +
                "Justicia. Texas, EUA.\n" +
                "\n" +
                "2015: Nombrada una de ‘Las 50 mujeres + poderosas de México’ por la Revista Forbes\n" +
                "México.\n" +
                "\n" +
                "2015: Candidatas como Las Patronas al premio Princesa de Asturias de la Concordia.\n" +
                "España.\n" +
                "\n" +
                "2014: Reconocimiento por su Loable Labor por parte del Gobierno del Estado de\n" +
                "Veracruz. México.", R.drawable.norma);

        ArrayList<DescriptionItem> list = new ArrayList<>();
        list.add(saul);
        list.add(jorge);
        list.add(juan);
        list.add(francisco);
        list.add(sergio);
        list.add(guadalupe);
        list.add(arturo);
        list.add(vidal);
        list.add(norma);

        //looks up ViewPager and sets its adapter
        mPager = (ViewPager) findViewById(R.id.description_pager);
        mPagerAdapter = new DescriptionPagerAdapter(getSupportFragmentManager(),list);
        mPager.setAdapter(mPagerAdapter);

        mPager.setCurrentItem(selectedPosition);
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);
    }

    /**
     * Enables drawer items to change the adapter current item
     */
    public void initDrawer()
    {
        RelativeLayout drawerInformation = (RelativeLayout) findViewById(R.id.drawer_information);
        drawerInformation.setOnClickListener(this);

        RelativeLayout drawerProgram = (RelativeLayout) findViewById(R.id.drawer_program);
        drawerProgram.setOnClickListener(this);

        RelativeLayout drawerMemories = (RelativeLayout) findViewById(R.id.drawer_memories);
        drawerMemories.setOnClickListener(this);

        RelativeLayout drawerVenue = (RelativeLayout) findViewById(R.id.drawer_venue);
        drawerVenue.setOnClickListener(this);

        RelativeLayout drawerRegister = (RelativeLayout) findViewById(R.id.drawer_register);
        drawerRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        drawerLayout.closeDrawer(Gravity.LEFT);

        int selection = 0;

        switch (v.getId())
        {
            case R.id.drawer_information:

                selection = 0;
                break;
            case R.id.drawer_program:

                selection = 1;
                break;
            case R.id.drawer_memories:

                selection = 2;
                break;
            case R.id.drawer_venue:

                selection = 3;
                break;
            case R.id.drawer_register:

                selection = 4;
                break;
        }

        Intent intent = new Intent(DescriptionActivity.this,MainActivity.class);
        intent.putExtra("selection",selection);
        this.finish();
        startActivity(intent);

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

            return  dataSet.get(position).getTitle();

        }
    }
}
