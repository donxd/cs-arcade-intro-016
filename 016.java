boolean areSimilar(int[] a, int[] b) {
    
    boolean similares = false;
    int [] posicionesDiferencias = getPosicionesDiferencias( a, b );

    if ( posicionesDiferencias == null ){
        similares = false;
    } else {

        if ( sinPosiciones( posicionesDiferencias ) || 
                intercambioPosicionesValoresIguales( a, b, posicionesDiferencias ) ){

            similares = true;
        }

    }

    return similares;
}

boolean sinPosiciones ( int [] posicionesDiferencias ){
    return posicionesDiferencias[ 0 ] == -1 && posicionesDiferencias[ 1 ] == -1;
}

boolean intercambioPosicionesValoresIguales ( int [] a, int [] b, int [] posicionesDiferencias ){
    return a[ posicionesDiferencias[ 0 ] ] == b[ posicionesDiferencias[ 1 ] ] && 
                a[ posicionesDiferencias[ 1 ] ] == b[ posicionesDiferencias[ 0 ] ];
}

int [] getPosicionesDiferencias ( int[] a, int[] b ){

    int [] posicionesDiferencias = new int []{ -1, -1 };

    int numeroDiferencias = 0;
    for ( int i = 0; i < a.length; i++ ){
        if ( a[ i ] != b[ i ] ){

            if ( numeroDiferencias > 1 ){
                posicionesDiferencias = null;
                break;
            }

            posicionesDiferencias [ numeroDiferencias ] = i;
            numeroDiferencias++;
        }

    }

    return posicionesDiferencias;
}