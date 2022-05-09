public class maze_path {
    public static void main(String[] args) {
      int val=  getMazePath(0, 0, 2, 2,"", new int[][]{{0,1},{1,0},{1,1}}, new String[]{"h","v","d"});
        System.out.println(val);
        System.out.println("------------------------------------------------");
        mazepathwithjump(0, 0, 2, 2,"", new int[][]{{0,1},{1,0},{1,1}}, new String[]{"h","v","d"});
        System.out.println("Flood fill --");
       val= floodfill(0,0,2, 2,"", new int[][]{{0,1},{1,0},{1,1}}, new String[]{"h","v","d"},new boolean[2][2]);
       System.out.print(val);
    }


    private static int getMazePath(int sr,int sc, int dr,int dc, String psf,int[][] dir,String[] dirs){

        
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return 1;
        }
      
        int count=0;

        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            String move=dirs[i];
            if(r>=0 && r<=dr && c>=0 && c<=dc){
              count+= getMazePath(r, c, dr, dc, psf+move+"", dir, dirs);
            }
        }

        return count;
    }
    public static void mazepathwithjump(int sr, int sc, int dr, int dc,String asf,int[][] dir,String[]dirs ){
      
        if(sr==dr && sc==dc){
            System.out.println(asf);
            return;
        }


        for(int i=0;i<dir.length;i++){
            for(int jump=1;jump<=Math.max(dr,dc);jump++){
                int r=sr+jump*dir[i][0];
                int c=sc+jump*dir[i][1];
                String move=dirs[i];

                if(r>=0 && r<=dr && c>=0 && c<=dc){
                    mazepathwithjump(r, c, dr, dc, asf+move+jump, dir, dirs);

                }else{
                    break;
                }
          }


        }

    }
    public static int floodfill(int sr,int sc, int dr,int dc, String psf,int[][] dir,String[] dirs,boolean[][]visited){
        if(sr==dr && sc==dc){
            System.out.println(psf);
            return 1;
        }
      
        int count=0;
        visited[sr][sc]=true;

        for(int i=0;i<dir.length;i++){
            int r=sr+dir[i][0];
            int c=sc+dir[i][1];
            String move=dirs[i];
            if(r>=0 && r<=dr && c>=0 && c<=dc){
                if(!visited[r][c])
                    count+= getMazePath(r, c, dr, dc, psf+move+"", dir, dirs);
                
            }
        }

        visited[sr][sc]=false;

        return count;

    }
}