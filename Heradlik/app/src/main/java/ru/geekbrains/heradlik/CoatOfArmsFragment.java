package ru.geekbrains.heradlik;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CoatOfArmsFragment extends Fragment {

    public static final String PARCEL = "PARCEL";

    public CoatOfArmsFragment() {
        // Required empty public constructor
    }

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы.
    public static CoatOfArmsFragment create(Parcel index) {
        CoatOfArmsFragment f = new CoatOfArmsFragment();    // создание

        // Передача параметра
        Bundle args = new Bundle();
        args.putSerializable(PARCEL, index);
        f.setArguments(args);
        return f;
    }

    // Получить индекс из списка (фактически из параметра)
    public int getIndex() {
        return getParcel().getImageIndex();
    }

    public Parcel getParcel(){
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Определить какой герб надо показать, и показать его
        View layout = inflater.inflate(R.layout.fragment_coat_of_arms, container, false);

        ImageView coatOfArms = layout.findViewById(R.id.imageView);
        TextView cityName = layout.findViewById(R.id.textView);

        // Получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        // Выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(getParcel().getImageIndex(), -1));
        cityName.setText(getParcel().getCityName());
        return layout;     // Вместо макета используем сразу картинку
    }
}
