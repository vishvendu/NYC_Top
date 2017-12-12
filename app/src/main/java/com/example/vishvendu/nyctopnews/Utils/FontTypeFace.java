package com.example.vishvendu.nyctopnews.Utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.TextView;

import com.example.vishvendu.nyctopnews.R;


public class FontTypeFace extends android.support.v7.widget.AppCompatTextView {

    /*
     * Permissible values ​​for the "typeface" attribute.
     */
    private final static int SOURCESANS_EXTRA_LIGHT = 0;
    private final static int SOURCESANS_EXTRA_LIGHT_ITALIC = 1;
    private final static int SOURCESANS_LIGHT = 2;
    private final static int SOURCESANS_LIGHT_ITALIC = 3;
    private final static int SOURCESANS_LIGHT_REGULAR = 4;
    private final static int SOURCESANS_ITALIC = 5;
    private final static int SOURCESANS_SEMI_BOLD = 6;
    private final static int SOURCESANS_SEMI_BOLD_ITALIC = 7;
    private final static int SOURCESANS_BOLD = 8;
    private final static int SOURCESANS_BOLD_ITALIC = 9;
    private final static int SOURCESANS_BLACK = 10;
    private final static int SOURCESANS_BLACK_ITALIC = 11;

    /**
     * List of created typefaces for later reused.
     */
    private final static SparseArray<Typeface> mTypefaces = new SparseArray<Typeface>(16);

    /**
     * Simple constructor to use when creating a view from code.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     */
    public FontTypeFace(Context context) {
        super(context);
    }

    /**
     * Constructor that is called when inflating a view from XML. This is called
     * when a view is being constructed from an XML file, supplying attributes
     * that were specified in the XML file. This version uses a default style of
     * 0, so the only attribute values applied are those in the Context's Theme
     * and the given AttributeSet.
     * <p/>
     * <p/>
     * The method onFinishInflate() will be called after all children have been
     * added.
     *
     * @param context The Context the view is running in, through which it can
     *                access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     * @see #FontTypeFace(Context, AttributeSet, int)
     */
    public FontTypeFace(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(context, attrs);
    }

    /**
     * Perform inflation from XML and apply a class-specific base style. This
     * constructor of View allows subclasses to use their own base style when
     * they are inflating.
     *
     * @param context  The Context the view is running in, through which it can
     *                 access the current theme, resources, etc.
     * @param attrs    The attributes of the XML tag that is inflating the view.
     * @param defStyle The default style to apply to this view. If 0, no style
     *                 will be applied (beyond what is included in the theme). This may
     *                 either be an attribute resource, whose value will be retrieved
     *                 from the current theme, or an explicit style resource.
     * @see #FontTypeFace(Context, AttributeSet)
     */
    public FontTypeFace(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseAttributes(context, attrs);
    }

    /**
     * Parse the attributes.
     *
     * @param context The Context the view is running in, through which it can access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    private void parseAttributes(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.FontTypeFace);

        int typefaceValue = values.getInt(R.styleable.FontTypeFace_typeface, 0);
        values.recycle();

        setTypeface(obtaintTypeface(context, typefaceValue));
    }

    /**
     * Obtain typeface.
     *
     * @param context       The Context the view is running in, through which it can
     *                      access the current theme, resources, etc.
     * @param typefaceValue values ​​for the "typeface" attribute
     * @return Roboto {@link Typeface}
     * @throws IllegalArgumentException if unknown `typeface` attribute value.
     */
    private Typeface obtaintTypeface(Context context, int typefaceValue) throws IllegalArgumentException {
        Typeface typeface = mTypefaces.get(typefaceValue);
        if (typeface == null) {
            typeface = createTypeface(context, typefaceValue);
            mTypefaces.put(typefaceValue, typeface);
        }
        return typeface;
    }

    /**
     * Create typeface from assets.
     *
     * @param context       The Context the view is running in, through which it can
     *                      access the current theme, resources, etc.
     * @param typefaceValue values ​​for the "typeface" attribute
     * @return Roboto {@link Typeface}
     * @throws IllegalArgumentException if unknown `typeface` attribute value.
     */
    private Typeface createTypeface(Context context, int typefaceValue) throws IllegalArgumentException {
        Typeface typeface;
        switch (typefaceValue) {
            case SOURCESANS_EXTRA_LIGHT:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-ExtraLight.ttf");
                break;
            case SOURCESANS_EXTRA_LIGHT_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-ExtraLightItalic.ttf");
                break;
            case SOURCESANS_LIGHT:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Light.ttf");
                break;
            case SOURCESANS_LIGHT_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-LightItalic.ttf");
                break;
            case SOURCESANS_LIGHT_REGULAR:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Regular.ttf");
                break;
            case SOURCESANS_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Italic.ttf");
                break;
            case SOURCESANS_SEMI_BOLD:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-SemiBold.ttf");
                break;
            case SOURCESANS_SEMI_BOLD_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-SemiBoldItalic.ttf");
                break;
            case SOURCESANS_BOLD:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Bold.ttf");
                break;
            case SOURCESANS_BOLD_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-BoldItalic.ttf");
                break;
            case SOURCESANS_BLACK:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Black.ttf");
                break;
            case SOURCESANS_BLACK_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-BlackItalic.ttf");
                break;
            default:
                throw new IllegalArgumentException("Unknown `typeface` attribute value " + typefaceValue);
        }
        return typeface;
    }

}