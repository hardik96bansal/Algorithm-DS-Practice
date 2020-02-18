#00 01 02 03 04 05 06 07
#10 11 12 13 14 15 16 17
#20 21 22 23 24 25 26 27

def isValid(board,x,y):
    if(x>-1 and x<5 and y>-1 and y<5 and board[x][y]==-1):
        return True
    else:
        return False

def solve():
    board= [[-1 for i in range(8)]for i in range(8)] 
    board[0][0] = 0
    moveX = [1,2,-1,-2, 1, 2,-1,-2]
    moveY = [2,1, 2, 1,-2,-1,-2,-1]

    if(solveUtil(board,0,0,moveX,moveY,1)):
        print(board)
    else:
        print(-1)


def solveUtil(board,currX,currY,moveX,moveY,pos):
    if pos==64:
        return True
    
    for i in range(8):
        newX = currX + moveX[i]
        newY = currY + moveY[i]
        if(isValid(board,newX,newY)):
            board[newX][newY] = pos
            if(solveUtil(board,newX,newY,moveX,moveY,pos+1)):
                return True
            else:
                board[newX][newY] = -1
    return False
        
solve()