package edu.pujadas.eduardpujadasacttres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Dades mock

//user : EduardPujadas2002
//pass: EPF2002

public class MainActivity extends AppCompatActivity
    {
    EditText userName;
    EditText paswordInfo;
    Button login;
    String nameIntroduced= "";
    String passIntroduced="";

    // toast = alert
    Toast toastCorrect;
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // busca una id que es digui username
        userName = findViewById(R.id.userName);
        // busco per la id la password
        paswordInfo = findViewById(R.id.password);
        // busca el login amb la id de login
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener()
            {
            @Override
            public void onClick(View view)  // canviar aquest nom de funcio
                {
                    if(isName() && isPasswoord())
                    {
                        //open 2n activity
                        currentWeekActivity();
                    }


                }

                /**
                 * Method that returns if the username are correct if it does then apears a tost that says
                 * "Username correct"
                 * @return
                 */
           protected boolean isName()
                {
                    //obtinc el nom del edit text i el converteixo amb string
                    nameIntroduced = userName.getText().toString();
                    if(nameIntroduced.isEmpty())
                    {
                        userName.setError("Nom Usuari Buit");
                        return false;
                    }
                    else if(nameIntroduced.equals("EduardPujadas2002"))
                    {

                        createToast("Nom usuari Correcte! :D");
                        return true;

                    }

                    else
                    {
                        createToast("Incorrecte Nom usuari! D:");
                        return false;
                    }

                }

                /**
                 * Method thats checks if the password is correct if isn't they return false and a toast
                 * that says "Password incorrect"
                 * @return
                 */
                protected boolean isPasswoord()
                {
                    //obtinc el nom del edit text i el converteixo amb string
                    passIntroduced = paswordInfo.getText().toString();
                        // primer comprovar si la password introduida te més de 5 caracters

                    if(!passIntroduced.isEmpty())
                    {
                        if(passIntroduced.length() <5)
                        {
                            //incorrecte
                            createToast("Password to short :(");
                            return false;
                        }
                        else if (passIntroduced.equals("EPF2002"))
                        {
                            createToast("PASSWORD CORRECTE :D");
                            return true;

                        }
                        else
                        {
                            createToast("Passowrd incorecte");
                            return false;
                        }
                    }
                    else
                    {
                        paswordInfo.setError("Password Vuida");
                        return  false;

                    }



                }
            });
        }

        /**
         * metode per poder crear un toast
         * @param texte
         */
        protected void createToast(String texte)
        {
            // agafo el contexte de la app
            Context context = getApplicationContext();
             // aqui aniria el texte que voldria pero com que el passo per parametre no el necessito
            // ja que com que crido la funcio a molts de llocs doncs ja puc posar el missatge que vull
            // a traves del parametre

            //duracio del toast
            int duracio = Toast.LENGTH_LONG;
            // crido el tosat i creo un text
            toastCorrect=Toast.makeText(context,texte,duracio);
            toastCorrect.show();    // finalment el mostro

        }

        /**
         * Method that when u click the buton and u login thats tranform to a new activity
         */
        protected  void currentWeekActivity()
        {
            Intent intent = new Intent(this, currnetWeek.class);
            startActivity(intent);
        }


    }