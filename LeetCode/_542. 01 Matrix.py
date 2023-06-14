class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        m,n=len(mat),len(mat[0])
        q=[]
        visited=set()

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append((i,j))
                    visited.add((i,j))

        while(q):
            x,y=q.pop(0)
            for dx,dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                nx,ny=x+dx,y+dy
                if(0<=nx<m) and (0<=ny<n) and (nx,ny) not in visited:
                    mat[nx][ny]=mat[x][y]+1
                    q.append((nx,ny))
                    visited.add((nx,ny))

        return mat
