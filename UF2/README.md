# UF2

Todo el contendio impartido en la unidad formativa 2 de Android Studio 

## Índice

1. [Google Maps & Permisos & MapView](#google-maps--permisos--mapview)
2. [ScrollView](#scrollview)
3. [Splash Activity](#splash-activity)
4. [RecyclerView Adapter](#recyclerview-adapter)
5. [SharedPreferences](#sharedpreferences)
6. [Intent](#intent)

## Google Maps & Permisos & MapView

- Permisos & Google Maps & MapView y dependecias
    ```
        // poner esto en el gradle de dependecias
        implementation("com.google.android.gms:play-services-maps:18.2.0")
        
       <!--Permisos-->
          <uses-permission android:name="android.permission.INTERNET"/>
          <uses-permission
          android:name="android.permission.ACCESS_COARSE_LOCATION"/>
          <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>


        <!-- Posar dintre de <application>-->
        <meta-data
        android:name="com.google.android.geo.API_KEY"
        android:value="AIzaSyBB0KizOiZqjB90xyrIC2tiJTsvjYQIVx4" />



        //On mapView → Overide methods

        mapView.getMapAsync(new OnMapReadyCallback() {
        //overwrite methods
        });
    ```



## ScrollView

- Ejemeplo ScrollView 
```
    <HorizontalScrollView
            android:id="@id/scroll_view"
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:contentDescription="@string/app_name"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent">

        <LinearLayout
            android:id="@+id/container"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            tools:ignore="ExtraText,VisualLintBounds">

            <ImageView
                android:id="@+id/car1"
                android:layout_width="200dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:contentDescription="@string/todo"
                android:src="@drawable/car_1" />
                
            <!--Add more frontend-->

        </LinearLayout>

    </HorizontalScrollView>
```

## Splash Activity

- La Splash Activity es simplemente poner un temporizador a una activity

```
    Handler handler = new Handler();
    handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
        finish();
     }
    },2000);
```


## RecyclerView Adapter and Frontend
- Ejemplo de como hacer un adaptador y como poner el item.xml de RecyclerView. ¡Importante! Cambiar la clase y poner otra a medida. Tambien como inicializar el recicycler view .Tambien initRecycler
```
	//en el metodo on create()

        listHomes = new ArrayList<>();
        if(listHomes.isEmpty())
        {
            initData();
        }
        initRecylcerView();

 private void initRecylcerView()
    {
        //recicleview
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        homeAdapter = new HomeAdapter(listHomes);
        recyclerView.setAdapter(homeAdapter);
        //homeAdapter.notifyDataSetChanged();
    }
```



```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    tools:ignore="UseCompoundDrawables">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginTop="10dp"
        android:layout_marginEnd="10dp"
        android:layout_marginBottom="10dp"
        android:paddingBottom="0dp">

        <ImageView
            android:id="@+id/logoHome"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_marginStart="10dp"
            android:layout_marginTop="10dp"
            android:layout_marginBottom="10dp"
            android:contentDescription="@string/todo"
            tools:srcCompat="@tools:sample/avatars" />

        <TextView
            android:id="@+id/city"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="120dp"

            android:layout_marginTop="50dp"
            android:layout_marginBottom="10dp"
            android:text="@string/textview"
            android:textAlignment="center" />

    </androidx.cardview.widget.CardView>

</RelativeLayout>
```
```
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>
{
    //!change the Object
    private List<Home> listHomes = new ArrayList<Home>(); 

    public HomeAdapter(List<Home> listHomes){
        this.listHomes=listHomes;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){ 
        
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);

        return new ViewHolder(vista) ;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position){
    
        String nomHome = listHomes.get(position).getName();   //!cambiar esto
        Bitmap img = listHomes.get(position).getImg();         //!cambiar esto
        holder.setData(nomHome,img);            
    }

    @Override
    public int getItemCount(){
        return listHomes.size();
    }


    // Class View Holder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView homeImg; //!change this
        TextView textHome; //!change this

            public ViewHolder(@NonNull View itemView){
                super(itemView);
                homeImg = itemView.findViewById(R.id.logoHome); //! change this
                textHome = itemView.findViewById(R.id.city); //! change this
            }

        // Set Data Custom Method
        public void setData(String nomHome, Bitmap img){
            homeImg.setImageBitmap(img);
            textHome.setText(nomHome);
        }
    }
}
```

## SharedPreferences

- El shared prefences es una forma de enviar informacion a través de acitivtys

```
//Creating a simple shared prefs
SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();

//Add a string Example
editor.putString("username", "EjemploUsuario");
editor.apply();

// How to recuparate the info
SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
String username = sharedPreferences.getString("username", " ");
```

## Intent

- Forma de enviar información através de activitys y para saltar de activitys

```
Intent intent = new Intent(getApplicationContext());
intent.putExtra("hola")

//startActivity(intent);
//finish();

```
