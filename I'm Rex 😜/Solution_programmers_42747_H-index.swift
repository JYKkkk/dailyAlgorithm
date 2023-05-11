//
//  Solution_programmers_42747_H-index.swift
//  SwiftAlgo
//
//  Created by kimyounghwan on 2023/05/11.
//

import Foundation

func solution(_ citations:[Int]) -> Int {
    let C = citations.sorted(by: >)
    for h in 0..<C.count {
        if h >= C[h] {
            return h
        }
    }
    return C.count
}

print(solution([3,0,6,1,5]))
