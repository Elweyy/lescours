/*..............................................................................
................................................................................
................................................................................
................................................................................
................................................................................
........................:DMNMMMMMMMMMMMMNNMMMMMMMMMMNNNMMMMMMM..................
..................=MMMMMMMO: .....  ?NMM$:   .7MZ ...........DMN................
...............NMM~....................  ,:,  .....,M .........MM+..............
............NMM:...~  =8MMOI?7OMMNMD .......... +MZ...OI........MMZ.............
..........MMN...........................,  .,?DMN,...N ..M.......MM?............
.........,M,.......M........ 8.........  ...........?8.~O..$......NM............
.........DM.................M..........$...............M. .........MM...........
.........MM......,...........O.........~......?OOI......O..:.......?M:..........
........MM...........   .....Z.......... MMMM7MMMMMMMMI.............ZMN.........
......7MM.........MMMMNMMMMN:..........MM+....MMMMMM7 MM.. ......... .MM .......
.....MM7.NM+ ... .OMMMMMMMMMMM,MM.....MM . MMMMMMDDMNMMMM.:M.....   .D==MN......
....MM D .: ............... MMM7.......MMMM ....DM..........ONMMMMN8....? MM....
...8MZ7.D .,MMM=............ M ..................NMM.....:NMMN ....MMD...  MM...
...MM :.M.NMD, +MMM.ZM ..... M ....................?MMNNMM? ...M.....NM..M.:M ..
...OM  .M.....N..NNNM......NMN...............................8MMN.... M .N..MM..
....M~=.N.... M,.........NM8.......... MNMMMM............,MMMN  MMM,..M,.M..MM..
....DMM...7..NMI.......MMMM......... , ...MM..........OMMMM ...NMI8MONM..=. MZ..
.....NM.DM..MMMM....D~..8.MM......+NMMMM DMD..... MMMMMM,.....8MN....M . ..MM...
......MM....MMMMMM......... MM?M~........  . MNMMNO .. MI...MMMM+......I..MM....
...... M8.. MMM,MMMMMM ......,M ..... +MNMMMM.........MMMMMMNMM...... ..MMM.....
.......NN.. MMM.MM. DMMMMMMNNNNNMMMMMMMN, ..MN..... MMMMM8..MM........7MM ......
.......DM...MMN.MM..MM..... MD ...+M........MM.MMMMMMMNM ..MN........IMM........
.......,M . MMMMMMM.NM .....M.....+M..... 8MMMMMMMM,..OM.,MN........ MM.........
........M ..MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .......NMMM.........MM..........
.......,M...NMMMMMMMMMMMMMMMMMMMMMMMMMMMMM=..MM.......OMM,.........:M ..........
.......7M...OM MMMMMMMMMMMMMMMMMMMNMM8.......+MO....MMMO..........=MD...........
.......MM....MM~M.$M .,M .. MM......NN........NM ,MMM,...........MM,............
.......NM.....MM7..MM .NM... M......MM....... MMMMN.... O.. 8..MMM..............
.......MI......OMMMMMN8,MM...NM.....MMD$MMMMMMM,... M~..+M+..MMN................
...... M ......... IMMMMMMMMMMMMMMMMMMMMMM$ .....M7...MD..,NMM..................
......:M ..?...~.............................:M.. MM ..,NMN.....................
......ZM...=.... N:..................... 7M,..MN ...8MMM........................
......DM....+....... ,?7Z7?=~~:       . ?M? .... MMMN...........................
......8M......=NZ .............  +M8. ........MMMM..............................
...... MD..................................MMMI.................................
....... MM......................... MMNMNMN~....................................
.........MMN ................. DNMMMMMM:........................................
...........DMMMNMMO$7ZDMMNMMMMM8 ...............................................
............... =ONMMD$: .......................................................
................................................................................
................................................................................
..............................................................................*/
public class TestListeChainee {

	// TODO tests � ecrire a partir de TestListeContigue
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		if ((args.length==1)&&(args[0].equals("-text")))
			Lanceur.lanceSansInterface(new TestListeChainee());
		else
			Lanceur.lanceAvecInterface(new TestListeChainee());
	}

}
