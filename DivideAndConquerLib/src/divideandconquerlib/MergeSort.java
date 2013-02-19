package divideandconquerlib;

public class MergeSort {
	
	public static int[] mergeSort(int[] vetorDesordenado) {
		return mergeSort(vetorDesordenado, vetorDesordenado.length-1);
	}
	
	private static int[] mergeSort(int[] arrayUnsorted, int x)
	{
		int[] returnValue;
		
		if (x == 0)
		{
			returnValue = arrayUnsorted;
		}
		else
		{
			int nEsq = x / 2;
			int nDir = nEsq + 1;

			int[] VetorEsq = QVetor(arrayUnsorted, 0, nEsq);
			int[] VetorDir = QVetor(arrayUnsorted, nDir, x);

			int[] VetorU_DeCombina = mergeSort(VetorEsq, nEsq);
			int[] VetorV_DeCombina = mergeSort(VetorDir, x-nDir);

			returnValue = Combina(VetorU_DeCombina, nEsq, VetorV_DeCombina, x-nDir);
		}
	
		return returnValue;
	}
	
	private static int[] QVetor(int[] ParVet, int inicio, int fim)
	{
		int[] VetorAux = new int[ParVet.length];

		int nn = 0;
		for (int i = inicio; i<=fim; i++) {
			VetorAux[nn] = ParVet[i];
			nn++;
		}
		
		return VetorAux;
	}
	
	private static int[] Combina(int[] VetorU, int nnn, int[] VetorV, int mmm)
	{
		int i, j, w;
		int[] VetorW = new int[VetorU.length];

		VetorU[nnn + 1] = Integer.MAX_VALUE;
		VetorV[mmm + 1] = Integer.MAX_VALUE;
		w = 0;
		i = 0;
		j = 0;
	
		while (i <= nnn || j <= mmm) {
			if (VetorU[i] <= VetorV[j]) {
				VetorW[w] = VetorU[i];
				i++;
			} else {
				VetorW[w] = VetorV[j];
				j++;
			}
			w++;
		}
		
		return VetorW;
	}
	
}
